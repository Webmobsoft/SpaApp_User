1. Call the preferences file using
    Preferences.getInstance(this);

2. functions usage
    a) To get the user id
        Preferences.getInstance(this).getUserId(this);

    b) To store the user id
        Preferences.getInstance(this).storeUserId(this, "45");

    c) To clear the preferences
        Preferences.getInstance(this).clearPreferences();

    Like above you can use the remaining functions and also you can create your own functions inside the class and use them.

3. Declaring Preferences Keys
    a) copy the file named prefs.xml inside the /res/values/ folder.
    b) whenever you want to store new preferences key and value, create the key in prefs.xml file and use this for storing the value.
    c) by doing this there is no chance of mistake or misspelling while getting the value based on the key.

4. Preferences File Name
   if you want to change the name of preferences file then change it in prefs.xml file under key "preferencesFile".
   default value is "my_prefs.prefs".