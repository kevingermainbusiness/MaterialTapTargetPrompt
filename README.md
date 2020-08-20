# MaterialTapTargetPrompt
A Tap Target implementation (example) in Android based on Material Design Onboarding guidelines, using [MaterialTapTargetPrompt dependency](https://github.com/sjwall/MaterialTapTargetPrompt) as library.

![Showcases how the prompt looks on app](https://github.com/sjwall/MaterialTapTargetPrompt/blob/master/docs/assets/example_FAB.png)

## Built with

* [MaterialTapTargetPrompt](https://github.com/sjwall/MaterialTapTargetPrompt) - The dependency used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Maven SharedPreferences](https://mvnrepository.com/artifact/androidx.preference/preference-ktx/1.1.0-alpha02) - Used to save first time launch boolean variable in the app's storage.

### Quick Start

Add the following to ``` build.gradle```:

```gradle
repositories {
    jcenter()
}

dependencies {
    // MaterialTapPrompt dependency
    implementation 'uk.co.samuelwall:material-tap-target-prompt:3.0.0'
    
    // Preferences dependency
    implementation "androidx.preference:preference-ktx:1.1.1"
}
```

Inside the ``` android{ } ```tag add:
```gradle
android {

    defaultConfig {
        vectorDrawables.useSupportLibrary true
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

See [this link](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details & more information about the library.

