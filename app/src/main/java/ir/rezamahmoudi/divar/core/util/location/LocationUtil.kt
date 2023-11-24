package ir.rezamahmoudi.divar.core.util.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices

fun Context.hasLocationPermission(): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}

@SuppressLint("MissingPermission")
fun Context.getCurrentLocation(callback: (Location) -> Unit) {
    if (hasLocationPermission().not()) return
    LocationServices.getFusedLocationProviderClient(this).lastLocation
        .addOnSuccessListener { location -> location?.let { callback(it) } }
}
