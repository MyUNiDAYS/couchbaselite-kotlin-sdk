<h1 align="left">Couchbase Lite Kotlin SDK
<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/MyUNiDAYS/template-kotlin-library?style=flat-square"> <a href="https://git.live"><img src="https://img.shields.io/badge/collaborate-on%20gitlive-blueviolet?style=flat-square"></a>
</h1>

A Kotlin Multiplatform wrapper for Couchbase Lite

## Installation

```
implementation("com.myunidays:couchbaselite:0.0.1")
```


## How to use

### KMM

The api is based on the android sdk, I would recommend you use https://docs.couchbase.com/couchbase-lite/current/android/quickstart.html as the main point of reference.

```kotlin
CouchbaseLite.init(context) //initialise for android use Context for ios use null or NSBundle
val database = Database(dbName)
val collection = database.createCollection(collName)
```

## Contributing

This project is set up as an open source project. As such, if there are any suggestions that you have for features, for improving the code itself, or you have come across any problems; you can raise them and/or suggest changes in implementation.

If you are interested in contributing to this codebase, please follow the contributing guidelines. This contains guides on both contributing directly and raising feature requests or bug reports. Please adhere to our code of conduct when doing any of the above.
