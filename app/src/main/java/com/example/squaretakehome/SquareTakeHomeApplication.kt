package com.example.squaretakehome

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SquareTakeHomeApplication: Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache{
                MemoryCache.Builder(this)
                    .maxSizePercent(0.10)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .maxSizeBytes(1024 * 1024 * 100)
                    .build()
            }
            .respectCacheHeaders(false)
            .build()
    }
}