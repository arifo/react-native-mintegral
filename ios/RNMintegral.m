
#import "RNMintegral.h"

@implementation RNMintegral

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(setup: (NSString *)appId appKey:(NSString *)appKey) {
    RCTLogInfo(@"setup appId %@", appId);
    RCTLogInfo(@"setup appKey %@", appKey);
};

RCT_EXPORT_METHOD(initHandler: (NSString *)unitId) {
    RCTLogInfo(@"initHandler unitId %@", unitId);
};

RCT_EXPORT_METHOD(showAd) {
    RCTLogInfo(@"show add");
};

@end
  
