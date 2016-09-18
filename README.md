# FLHS-Patriot-Battalion
An Android Application
This Application specs:
Target API:23
Min API:16
*there is a google-service.json in this project however isnt withen this repository"
This is the beta 1.3

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'


    compile 'com.google.firebase:firebase-core:9.4.0'
    compile 'com.google.firebase:firebase-database:9.4.0'
    compile 'com.google.firebase:firebase-crash:9.4.0'

        compile "com.google.firebase:firebase-messaging:9.4.0"

    compile 'com.android.support:appcompat-v7:23.4.0'
    compile 'com.firebase:firebase-client-android:2.3.1'
    compile 'com.android.support:design:23.4.0'
    compile 'com.android.support:support-v4:23.4.0'
}
