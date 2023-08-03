# Battle Cats

[JADX](https://github.com/skylot/jadx) decompilation of The Battle Cats

Current Version: `JP 1.0.0`

I have made enough changes to get the project to compile successfully, however there are many issues
with the game. Some issues are in the original APK (e.g no screen transitions, blue overlay) but
lots aren't.

I started with version 1.0.0 because it has the least amount of code and so it is easier to get a
compiling a functional app. Once this version is fully working we can move on to adding later
versions.

I have also removed all of the advertising and tracking code for now.

I got the original APK from here: <https://apkfree.com/download/battle-cats-1.0.0>
it is a 999999 cat food APK, but I have removed all of that code in the new APK.

## Building

1. [Download Android Studio](https://developer.android.com/studio)
2. Clone this repository using `git` or by downloading the zip and extracting it
3. Open the project in Android Studio
4. Wait for it to download the necessary files
5. Go to the `Build` tab in the main toolbar and click `Build Bundle(s) / APK(s)` -> `Build APK(s)`
6. It might need to download more stuff so just wait
7. When done, click `locate` in the notification or go to the
`battlecats/app/build/outputs/apk/debug` folder

## Contributing

If you want to contribute, then I recommend that you decompile the original APK using jadx so that
you can use stuff like the smali view or the cfg graphs in the gui to help fix issues with the
decompilation.

If you want to view the java code for large functions in jadx but jadx skips it because the cfg
modification limit has been reached, then you will need to modify the jadx source code and compile
it yourself to remove the limit. Just search for `CFG modification limit reached` in the code and
comment out the if block. The file containing that code is here:
`jadx-core/src/main/java/jadx/core/dex/visitors/blocks/BlockProcessor.java`

Most of the issues are probably around jadx incorrectly decompiling control flow stuff like loops
and if statements. Jadx creates lots of `while(true)` loops with no way for them to stop. I have
fixed some of those from looping infinitely, although I'm not confident I did that correctly.
So if you are looking for sources of error check for those loops first.