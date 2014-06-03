Teech.io Android Library
=========
-----
##Install and run the SDK:

#### Step (1) 
Import the .jar into your existing Android project by copying it into the "libs" folder. If your project does not already have a "libs" folder, create one at the root of the project.

#### Step (2) 
Add the .jar to build path. If you use Eclipse: right click on the .jar file and then select "Build Path" > "Add to Build Path".

#### Step (3)
Your app must request the ```INTERNET``` and ```ACCESS_NETWORK_STATE``` permissions, if it isn't doing so already. Add these lines before the <application> tag in your AndroidManifest.xml:
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

#### Step (4)
Import in your Activities or Fragments ``` import teech.sdk.Teech;```

#### Step (5) 
Add on the method ```onCreate()``` the initialization: 
```java
Teech.init("YourApiKey","YourAppKey");
```

**Hell Yeah, now you only need to build your awesome education Android app!**

------
This is an example of Activity:
```java
import teech.sdk.Teech;
import android.app.Fragment;
import android.os.Bundle;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Teech.init("0wh2OEEb&5sjd834dVjXXXXX3218498c","a384612XXXX2OEEb&5sjd2147581");//Teech.io initialization

	}
}
```

Version
----

Beta 0.3.1

Teech.io Docs
-----------

* [Android] - Android Docs
* [RestApi] - REST API Docs
* [Twitter] 
* [Website]
* [Drop us a line]



License
----

MIT

[Android]:http://teech.io/docs/android/
[RestApi]:http://teech.io/docs/rest-api/
[Twitter]:https://twitter.com/teech_io
[Website]:http://www.teech.io
[Drop us a line]: mailto:support@teech.io

