# Before After Image Comparison

[![](https://jitpack.io/v/Sudo-Rahman/BeforeAfterImage.svg)](https://jitpack.io/#Sudo-Rahman/BeforeAfterImage)

A simple library to compare two images with a slider.

## Demo



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
    beforeText: String = "Before",
    afterText: String = "After",
    enableThumbBorder: Boolean = true
) {}
```

* With image url
``` kotlin
@Composable
fun BeforeAfterImage(
    beforeImageUrl: String,
    afterImageUrl: String,
    modifier: Modifier = Modifier,
    beforeText: String = "Before",
    afterText: String = "After",
    enableThumbBorder: Boolean = true
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
    beforeText = "Before",
    afterText = "After",
    enableThumbBorder = true
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
    beforeText = "Before",
    afterText = "After",
    enableThumbBorder = true
)
```
