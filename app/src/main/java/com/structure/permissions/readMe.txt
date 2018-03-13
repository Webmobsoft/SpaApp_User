Example for Location Permission.

1.if (!PermissionsAndroid.getInstance().checkLocationFinePermission(this) && !PermissionsAndroid.getInstance().checkLocationCoarsePermission(this)) {
      PermissionsAndroid.getInstance().requestForLocationPermission(this);
  } else {
      Toast.makeText(MainActivity.this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
      // do your work
  }

2. Override the onRequestPermissionsResult
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionsAndroid.LOCATION_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    // do your work here
                } else if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                    Toast.makeText(MainActivity.this, "Go to Settings and Grant the permission to use this feature.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }