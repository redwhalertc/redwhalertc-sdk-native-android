# 目的

红鲸音视频Native Android SDK是为Android原生应用集成音视频SDK而开发的，本文档介绍如何红鲸音视频Android SDK集成到Android的原生应用中。

# Android Studio配置
推荐使用Android Studio作为Android的开发工具

# 创建Android Studio项目
在Android Studio中创建或打开一个Android项目

# 在项目中集成rwrtc-android-sdk
我们提供视频会议的核心SDK的AAR文件。

1. 下载rwrtc-android-sdk.aar文件
2. 将aar文件拷贝至需要此SDK的module的libs目录下，如图

![拷贝至libs目录下](/figure/libs.png)

如果Android工程只有一个主Module且名字为app，则放到app/libs目录下即可

3. 在使用该SDK的Module的build.gradle的dependencies节点下添加aar的依赖说明。

此处根据gradle的版本不同，依赖方式也有所区别，主要有两种依赖方式，具体如下：

高版本gradle：
```
dependencies {
    api fileTree(dir: 'libs', include: ['*.jar','*.aar'])
} 
```
低版本gradle：
```
repositories {
    flatDir {
        dirs 'libs' 
    }
}

dependencies {
    api(name: 'rwrtc-android-sdk', ext: 'aar')
 } 
```
4. 添加SDK依赖的第三方库
```
 dependencies {
    api 'io.github.webrtc-sdk:android-prefixed:125.6422.06.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0'
    api 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.25"
    api 'com.squareup.okhttp3:okhttp:4.12.0'
    api 'com.github.davidliu:audioswitch:89582c47c9a04c62f90aa5e57251af4800a62c9a'
    api 'androidx.annotation:annotation:1.7.1'
    api 'androidx.core:core:1.13.1'
    api 'com.google.protobuf:protobuf-javalite:3.22.0'
    api 'androidx.camera:camera-core:1.3.3'
    api 'androidx.camera:camera-camera2:1.3.3'
    api 'androidx.camera:camera-lifecycle:1.3.3'
    api 'javax.sip:android-jain-sip-ri:1.3.0-91'
    implementation 'com.google.dagger:dagger:2.46'
    kapt 'com.google.dagger:dagger-compiler:2.46'
    api 'com.github.ajalt:timberkt:1.5.1'
    implementation 'com.vdurmont:semver4j:3.1.0'
 } 
```
5. 至此，已本地依赖集成SDK。

# SDK权限说明

因为SDK涉及到音视频内容，所以需要申请网络、照相机、录音等权限。故AndroidManifest文件中需要添加
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
```
Android 6.0以后，照相机和录音等权限需要在代码中动态申请。

# SDK编译版本说明

gradle版本为
```
dependencies {
    classpath "com.android.tools.build:gradle:8.7.2"
}
```
Kotlin版本为 1.9.25
JDK版本为 1.8
Android SDK版本
|                | 版本 |
|----------------|---- |
| compileVersion | 35 |
| targetVersion  | 35 |
| minVersion     | 21 |
