# ------------------------------
# 1. TEMEL AYARLAR
# ------------------------------
-dontwarn
-ignorewarnings
-dontnote
-optimizations !code/simplification/arithmetic

# ------------------------------
# 2. KÜÇÜLTME, OPTİMİZE ETME, ÖNDOĞRULAMA
# ------------------------------
-dontoptimize
-dontpreverify
-dontshrink

# ------------------------------
# 3. REFLEKSİYON, ONCLICK vb. KORUMA
# ------------------------------
-keepclassmembers class * {
    public void *(android.view.View);
}
-keepattributes Signature,InnerClasses,EnclosingMethod

# ------------------------------
# 4. ANDROID GEREKSİNİMLERİ
# ------------------------------
-keep class android.support.** { *; }
-keep class androidx.** { *; }
-keep class com.google.** { *; }
-keep class android.** { *; }

# ------------------------------
# 5. SKETCHWARE / UYGULAMA PAKETLERİ
# ------------------------------
-keep class com.my.** { *; }
-keep class com.bilgimobile.** { *; }

# ------------------------------
# 6. ACTIVITY, SERVICE, RECEIVER, CONTENTPROVIDER
# ------------------------------
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends androidx.appcompat.app.AppCompatActivity

# ------------------------------
# 7. JSON / GSON İÇİN KORUMA
# ------------------------------
-keep class com.google.gson.** { *; }
-keep class sun.misc.Unsafe { *; }

# ------------------------------
# 8. İSİM GİZLEME (OBFUSCATION)
# ------------------------------
-repackageclasses
-flattenpackagehierarchy
-useuniqueclassmembernames
-overloadaggressively

# ------------------------------
# 9. JAVA REFLECTION (daha fazla güvenlik için)
# ------------------------------
-keepclassmembers class * {
    *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}