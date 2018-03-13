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

package com.structure.ui.base;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.structure.R;
import com.structure.interfaces.TryAgainInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by deepak on 30/5/16.
 */
public class BaseFragment extends Fragment {

    /**
     * function to display the short message in toast.
     *
     * @param message  message to display
     * @param duration duration of the message
     */
    protected void showToast(String message, int duration) {
        if (TextUtils.isEmpty(message)) message = "";
        if (duration == 0) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * function to output the message.
     *
     * @param message message to display
     */
    protected void showOutput(String message) {
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        System.out.println(message);
        System.out.println("<<<<<<<<<<<<<<<<<<<");
    }

    /**
     * For Displaying the Log Output in Logcat
     *
     * @param tag     Tag of the Log
     * @param message Message of the Log
     */
    protected void showLog(String tag, String message) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        Log.d(tag, message);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<");
    }


    /**
     * function to check for the internet connection availability.
     *
     * @return boolean value
     */
    protected boolean isConnectedToInternet() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return (activeNetwork != null);
    }

    /**
     * function to check if the value is alphanumeric
     *
     * @param s string to be checked
     * @return boolean value
     */
    protected boolean isAlphaNumeric(String s) {
        String pattern = "^[a-zA-Z0-9]*$";
        if (s.matches(pattern)) {
            return true;
        }
        return false;
    }

    // function to displaySnackBar
    protected Snackbar snackbar = null;

    /**
     * function to display the message on Snackbar
     *
     * @param rootView view
     * @param message  message to display
     */
    protected void showCrouton(View rootView, String message) {
        snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    /**
     * function to display the message on Snackbar with TRY AGAIN
     *
     * @param rootView view
     * @param message  message to display
     * @param callback callback function to invoke on TRY AGAIN
     * @param service  service tag
     */
    protected void tryAgainCrouton(View rootView, String message, final TryAgainInterface callback, final String service) {
        snackbar = Snackbar
                .make(rootView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.tryAgain), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callback.tryAgain(service);
                    }
                });

        snackbar.show();
    }

    /**
     * function to hide the Snackbar
     */
    protected void hideCrouton() {
        if (snackbar != null && snackbar.isShownOrQueued())
            snackbar.dismiss();
    }

//    // bottom sheet dialog
//    View dialogView = null;
//    TextView messageTextView;
//    Button retry, cancel;
//    BottomSheetDialog bottomSheetDialog;
//
//    protected void showDialog(String message, final TryAgainInterface callback, final String service) {
//        if (dialogView == null) {
//            dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.retry_bottom_sheet, null);
//            messageTextView = (TextView) dialogView.findViewById(R.id.message);
//            retry = (Button) dialogView.findViewById(R.id.tryAgain);
//            cancel = (Button) dialogView.findViewById(R.id.cancel);
//        }
//
//        messageTextView.setText(message);
//        retry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetDialog.dismiss();
//                callback.tryAgain(service);
//            }
//        });
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetDialog.dismiss();
//            }
//        });
//        bottomSheetDialog = new BottomSheetDialog(getActivity());
//        bottomSheetDialog.setTitle("Hello");
//        bottomSheetDialog.setContentView(dialogView);
//        bottomSheetDialog.setCanceledOnTouchOutside(false);
//        bottomSheetDialog.setCancelable(false);
//        bottomSheetDialog.show();
//    }

    /**
     * function to parse the date from server
     *
     * @param date date to parse
     * @return parsed date
     */
    protected String getDate(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getString(R.string.dateInputFormat), Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(getResources().getString(R.string.timeZone)));
            Date myDate = simpleDateFormat.parse(date);

            SimpleDateFormat outputFormat = new SimpleDateFormat(getString(R.string.dateOutputFormat), Locale.ENGLISH);
            outputFormat.setTimeZone(TimeZone.getDefault());
            date = outputFormat.format(myDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * function to clear all the notifications
     */
    protected void clearNotifications() {
        try {
            NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            manager.cancelAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * function to clear the notification of particular ID
     *
     * @param id notification id
     */
    protected void clearNotifications(int id) {
        try {
            NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            manager.cancel(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // function to show the progress dialog
    ProgressDialog pd;

    /**
     * function to display the progress dialog
     */
    protected void showProgressDialog() {
        hideProgressDialog();
        pd = new ProgressDialog(getActivity(), R.style.progressDialogTheme);
        pd.setCancelable(false);
        pd.show();
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.default_progress_dialog, new LinearLayout(getContext()), false);
        pd.setContentView(v);
    }

    /**
     * function to hide the progress dialog
     */
    protected void hideProgressDialog() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        hideCrouton();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        hideCrouton();
        super.onDestroy();
    }
}
