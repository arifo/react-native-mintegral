
package com.arifodev.RNMintegral;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.mintegral.msdk.MIntegralConstans;
import com.mintegral.msdk.MIntegralSDK;
import com.mintegral.msdk.interstitialvideo.out.InterstitialVideoListener;
import com.mintegral.msdk.interstitialvideo.out.MTGInterstitialVideoHandler;
import com.mintegral.msdk.out.MIntegralSDKFactory;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class RNMintegralModule extends ReactContextBaseJavaModule {
  private MTGInterstitialVideoHandler mMtgInterstitalVideoHandler;

  private final ReactApplicationContext reactContext;

  MIntegralSDK sdk = MIntegralSDKFactory.getMIntegralSDK();

  public RNMintegralModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNMintegral";
  }

  @ReactMethod
  public void setup(String appId, String appKey) {
    Log.e(TAG, "=============setup=============");
    Map<String, String> map = sdk.getMTGConfigurationMap(appId, appKey);
    sdk.init(map, reactContext);
  }

  @ReactMethod
  public void preload(String unitId) {
    Log.e(TAG, "=============preload=============");
    Map<String, Object> preloadMap = new HashMap<String, Object>();
    preloadMap.put(MIntegralConstans.PROPERTIES_LAYOUT_TYPE, MIntegralConstans.LAYOUT_NATIVE);
    preloadMap.put(MIntegralConstans.PROPERTIES_UNIT_ID, unitId);
    preloadMap.put(MIntegralConstans.PROPERTIES_AD_NUM, 1);
    sdk.preload(preloadMap);
  }

  @ReactMethod
  public void initHandler(String unitId) {
    Log.e(TAG, "=============initHandler=============");
    try {
      mMtgInterstitalVideoHandler = new MTGInterstitialVideoHandler(reactContext, unitId);

      mMtgInterstitalVideoHandler.setInterstitialVideoListener(new InterstitialVideoListener() {

        public void onLoadSuccess(String unitId) {
          Log.e(TAG, "onLoadSuccess:" + Thread.currentThread());
        }

        public void onVideoLoadSuccess(String unitId) {
          Log.e(TAG, "onVideoLoadSuccess:" + Thread.currentThread());
          if (mMtgInterstitalVideoHandler != null && mMtgInterstitalVideoHandler.isReady()) {
            Log.e(TAG, "=============show ad=============");
            mMtgInterstitalVideoHandler.show();
          }
        }

        public void onVideoLoadFail(String errorMsg) {
          Log.e(TAG, "onVideoLoadFail errorMsg:" + errorMsg);
        }

        public void onShowFail(String errorMsg) {
          Log.e(TAG, "onShowFail=" + errorMsg);
        }

        public void onAdShow() {
          Log.e(TAG, "onAdShow");
        }

        public void onAdClose(boolean isCompleteView) {
          Log.e(TAG, "onAdClose rewardinfo :" + "isCompleteView：" + isCompleteView);
        }

        public void onVideoAdClicked(String unitId) {
          Log.e(TAG, "onVideoAdClicked");
        }

        public void onVideoComplete(String unitId) {
          Log.e(TAG, "onVideoComplete");
        }

        public void onEndcardShow(String unitId) {
          Log.e(TAG, "onEndcardShow");
        }

      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void showAd() {
    Log.e(TAG, "=============showAd method call=============");
    if (mMtgInterstitalVideoHandler != null) {
      Log.e(TAG, "=============load ad=============");
      mMtgInterstitalVideoHandler.load();
    }
  }

  @ReactMethod
  public void muteAd() {
    Log.e(TAG, "=============showAd method call=============");
    if (mMtgInterstitalVideoHandler != null) {
      Log.e(TAG, "bt_mute");
      mMtgInterstitalVideoHandler.playVideoMute(MIntegralConstans.REWARD_VIDEO_PLAY_MUTE);
    }
  }

  @ReactMethod
  public void unmuteAd() {
    Log.e(TAG, "=============unmuteAd method call=============");

    if (mMtgInterstitalVideoHandler != null) {
      Log.e(TAG, "bt_unmute");
      mMtgInterstitalVideoHandler.playVideoMute(MIntegralConstans.REWARD_VIDEO_PLAY_NOT_MUTE);
    }
  }

}