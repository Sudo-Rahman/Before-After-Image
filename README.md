# Before After Image Comparison

[![](https://jitpack.io/v/Sudo-Rahman/BeforeAfterImage.svg)](https://jitpack.io/#Sudo-Rahman/BeforeAfterImage)

A simple library to compare two images with a slider.

## Demo

https://github.com/Sudo-Rahman/BeforeAfterImage/assets/85690773/a7422cca-f6fe-4e1b-8fa9-e020fdadd764

## Gradle Dependency

* Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

* Step 2. Add the dependency

```
dependencies {
            implementation 'com.github.Sudo-Rahman:BeforeAfterImage:<latest-version>'
    }
```

## Components

* With image on local
``` kotlin
@Composable
fun BeforeAfterImage(
    beforeImage: Painter,
    afterImage: Painter,
    modifier: Modifier = Modifier,
    beforeLabel: String = "Before",
    afterLabel: String = "After",
    thumb: @Composable () -> Unit = { CustomThumb() }
) {}
```

* With image url

``` kotlin
@Composable
fun BeforeAfterImage(
    beforeImageUrl: String,
    afterImageUrl: String,
    modifier: Modifier = Modifier,
    beforeLabel: String = "Before",
    afterLabel: String = "After",
    thumb: @Composable () -> Unit = { CustomThumb() }
) {}
```

## Usage

* With image on local

``` kotlin
BeforeAfterImage(
    beforeImage = painterResource(id = R.drawable.before),
    afterImage = painterResource(id = R.drawable.after),
    modifier = Modifier
        .fillMaxWidth()
        .height(0.3f),
    beforeLabel = "Before",
    afterLabel = "After"
)
```

* With image url

``` kotlin
BeforeAfterImage(
    beforeImageUrl = "https://exemple.com/before.jpg",
    afterImageUrl = "https://exemple.com/after.jpg",
    modifier = Modifier
        .fillMaxWidth()
        .height(0.3f),
    beforeLabel = "Before",
    afterLabel = "After"
)
```
