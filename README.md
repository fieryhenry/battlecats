# Battle Cats

Decompilation of The Battle Cats based off of a
[dex2jar](https://github.com/pxb1988/dex2jar) and
[Fernflower](https://github.com/JetBrains/intellij-community/tree/master/plugins/java-decompiler/engine)
decompilation. [JADX](https://github.com/skylot/jadx) was used to fill in some
of the gaps in the decompilation as well as to create the initial Gradle
project.

Original APK: <https://apkfree.com/download/battle-cats-1.0.0>. It is a 999999
cat food APK, but all of that code has been removed

Current Version: `JP 1.0.0`

Version is 1.0.0 because it has the least amount of code and so it is the
easiest version to get a compiling and functional app. Once this version is
fully working we can move on to adding code for later versions.

Discord: <https://discord.gg/DvmMgvn5ZB> (The server is the same one which is
used for save editing as I haven't made a modding/decompilation specific one
yet)

## Prebuilt APKs

Prebuilt APKs can be found in the
[Releases](https://github.com/fieryhenry/battlecats/releases) section for the
major versions once they are working.

A debug APK can be found in the artifacts section of the
[Build APK](https://github.com/fieryhenry/battlecats/actions/workflows/build-apk.yml)
workflow. This APK is built from the latest code in the `master` branch and so
might not be working properly.

You need to be logged in to GitHub to download the APKs from the artifacts
section. So if you don't have an account, you can download it from
[here](https://nightly.link/fieryhenry/battlecats/workflows/build-apk/master/app-debug.apk.zip)
instead. You will also need to unzip it before you can install it.

## Building the APK yourself

1. [Download Android Studio](https://developer.android.com/studio)
2. Clone this repository using `git` or by downloading the zip and extracting it
3. Open the project in Android Studio
4. Wait for it to download the necessary files
5. Go to the `Build` tab in the main toolbar and click `Build Bundle(s) /
   APK(s)` -> `Build APK(s)`
6. It might need to download more stuff so just wait
7. When done, click `locate` in the notification or go to the
`battlecats/app/build/outputs/apk/debug` folder for the final APK which you can
then install.
8. You might need to sign the APK if you want to install it, so choose that
   option instead

## Contributing

If you want to contribute, you can fork the repository and make a pull request
with your changes. I want to keep the code somewhat close to the original APK
so that it is easier to update it with code from later versions.

When debugging the app, make sure that you are viewing the `GLThread` thread
instead of the `main` thread if you want to debug the main game code.

## Current Issues

Here are some current problems with the app:

- None at the moment, let me know if you find any

List is not exhaustive, there are probably lots of other issues that I haven't
noticed yet.

Some things look like issues but are actually in the original APK (e.g no screen
transitions, blurry icons) but some aren't. You can install the original APK at
the same time if you want to compare.
