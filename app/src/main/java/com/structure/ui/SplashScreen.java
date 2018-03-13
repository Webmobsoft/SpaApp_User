/*
 *
 *  *
 *  *  * Copyright (c) 2016, Mobilyte Tech India Pvt. Ltd. and/or its affiliates. All rights reserved.
 *  *  *
 *  *  * Redistribution and use in source and binary forms, with or without
 *  *  * modification, are permitted provided that the following conditions are met:
 *  *  *
 *  *  *  - Redistributions of source code must retain the above copyright
 *  *  *    notice, this list of conditions and the following disclaimer.
 *  *  *
 *  *  *  - Redistributions in binary form must reproduce the above copyright
 *  *  *    notice, this list of conditions and the following disclaimer in the
 *  *  *    documentation and/or other materials provided with the distribution.
 *  *
 *
 */

package com.structure.ui;

import android.content.Intent;
import android.os.Bundle;

import com.structure.preferences.Preferences;
import com.structure.ui.base.BaseActivity;

/**
 * Created by deepak on 30/8/16.
 */
public class SplashScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startActivity(new Intent(this, MainActivity.class));
        finish();
        if (Preferences.getInstance(SplashScreen.this).checkUserSession(SplashScreen.this)) {

        } else {

        }
    }
}
