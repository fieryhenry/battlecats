# Battle Cats

Decompilation of The Battle Cats based off of a
[JADX](https://github.com/skylot/jadx) decompilation

Original APK: <https://apkfree.com/download/battle-cats-1.0.0>. It is a 999999
cat food APK, but all of that code has been removed

Current Version: `JP 1.0.0`

Version is 1.0.0 because it has the least amount of code and so it is the
easiest version to get a compiling and functional app. Once this version is
fully working we can move on to adding code for later versions.

## Prebuilt APKs

Prebuilt APKs can be found in the
[Releases](https://github.com/fieryhenry/battlecats/releases) section for the
major versions once they are working.

A debug APK can be found in the artifacts section of the
[Build APK](https://github.com/fieryhenry/battlecats/actions/workflows/build-apk.yml)
workflow. This APK is built from the latest code in the `main` branch and so
might not be working properly.

## Building the APK yourself

NOTE: This app is very early in development and so it is basically unusable if
you want to play the original game. It is mainly for people who want to help fix
issues in the code or are interested in modding and want to test stuff out.

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

If you want to contribute, then I recommend that you decompile the original APK
using Jadx so that you can view stuff like the smali or simple view and the cfg
graphs to help fix issues with the decompilation.

If you get a message that the cfg modification limit has been reached and you
want to read the java code for that function, then you will need to modify the
jadx source code and compile it yourself to remove the limit. Search for `CFG
modification limit reached` in the code and comment out the `if` block. The file
containing that code is here:
`jadx-core/src/main/java/jadx/core/dex/visitors/blocks/BlockProcessor.java`

You should modify it to look like this:

```java
// if (i++ > 100) {
//     throw new JadxRuntimeException("CFG modification limit reached, blocks count: " + mth.getBasicBlocks().size());
// }
```

Then follow the build instructions on the jadx github page to build it yourself.

Most of the issues are probably around jadx incorrectly decompiling control flow
stuff like loops and if statements. Jadx creates lots of `while(true)` loops
with no way for them to stop. I have fixed some of those from looping
infinitely, although I'm not confident I did that correctly. So if you are
looking for sources of error check for those first.

Jadx also sometimes creates new local variables that don't exist e.g `r1` and
`r0`, most of these can be figured out by looking at surrounding code, but
again, I am not confident that these have all been fixed, so you should use jadx
to find those variables and check with the java code to look for errors.

When debugging the app, make sure that you are viewing the `GLThread` thread
instead of the `main` thread if you want to debug the main game code.

I want to keep the code as close to the original APK as possible so that it is
easier to update it with code from later versions.

## Current Issues

Here are some current problems with the app:

- [ ] Some animations are broken
- [ ] Can't really scroll in the upgrade menu
- [ ] Freezing if too many enemies die
- [ ] Cat cannon firing strangely

List is not exhaustive, there are probably lots of other issues that I haven't
noticed yet.

Some things look like issues but are actually in the original APK (e.g no screen
transitions, blurry icons) but lots aren't. You can install the original APK at
the same time if you want to compare.
