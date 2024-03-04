package com.example.composecoilcaching

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger

class App : Application(), ImageLoaderFactory {

    //this is a singleton instance for coil
    override fun newImageLoader(): ImageLoader {
        return ImageLoader(this).newBuilder()
            .memoryCachePolicy(CachePolicy.ENABLED)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.2) //percentage of memory to allocate for caching
                    .strongReferencesEnabled(true)// to protect it from garbage collector
                    .build()
            }
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                DiskCache.Builder()
                    .maxSizePercent(0.05)//percentage of disk memory to allocate for caching
                    .directory(cacheDir)// caching dir
                    .build()
            }
            .logger(DebugLogger())//logger for testing and debugging
            .build()
    }
}