package com.example.practice13_3

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var gMap : GoogleMap
    lateinit var mapFrag : MapFragment
    lateinit var videoMark : GroundOverlayOptions
    lateinit var markArray : ArrayList<LatLng>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Google 지도 활용"

        mapFrag = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFrag.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap) {
        markArray = ArrayList()

        gMap = map
        gMap.mapType= GoogleMap.MAP_TYPE_SATELLITE
        gMap.moveCamera(newLatLngZoom(LatLng(37.568256, 126.897240), 15f))
        gMap.uiSettings.isZoomControlsEnabled= true
        gMap.setOnMapClickListener { point->
            videoMark = GroundOverlayOptions().image(
                BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round)).position(point, 100f, 100f)
            Log.e("태그", videoMark.toString())
            markArray.add(point)
            gMap.addGroundOverlay(videoMark)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0, 1, 0, "위성 지도")
        menu!!.add(0, 2, 0, "일반 지도")
        menu!!.add(0, 3, 0, "월드컵경기장 바로가기")
        var sm = menu!!.addSubMenu(1, 4, 0, "유명장소 바로가기")
        sm.add(1, 4, 0, "1번 유명장소")
        sm.add(1, 4, 0, "2번 유명장소")
        menu!!.add(0, 5, 0, "바로전 CCTV 지우기")
        menu!!.add(0, 6, 0, "모든 CCTV 지우기")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                gMap.mapType= GoogleMap.MAP_TYPE_HYBRID
                return true
            }
            2 -> {
                gMap.mapType= GoogleMap.MAP_TYPE_NORMAL
                return true
            }
            3 -> {
                gMap.moveCamera(newLatLngZoom(LatLng(37.568256, 126.897240), 15f))
                return true
            }
            5 -> {
                if(markArray.size == 0)
                    return true
                markArray.removeAt(markArray.size -1)

                gMap.clear()
                for(i in markArray.indices) {
                    videoMark.position(markArray[i], 100f, 100f)
                    gMap.addGroundOverlay(videoMark)
                }
                return true
            }
            6 -> {
                markArray.clear()
                gMap.clear()
                return true
            }
        }
        return false
    }
}