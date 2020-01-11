
# react-native-mintegral

## Getting started

`$ npm install react-native-mintegral --save`
or
`$ yarn add react-native-mintegral`

### Mostly automatic installation

`$ react-native link react-native-mintegral`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-mintegral` and add `RNReactNativeMintegral.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeMintegral.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.arifodev.RNMintegralPackage;` to the imports at the top of the file
  - Add `new RNMintegralPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-mintegral'
  	project(':react-native-mintegral').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-mintegral/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implement project(':react-native-mintegral')
  	```



## Usage
```javascript
import RNMTG from 'react-native-mintegral';

// TODO: What to do with the module?
RNMTG;
```
  