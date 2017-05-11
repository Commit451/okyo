# okyo

[okio](https://github.com/square/okio) made easy, yo

[![Build Status](https://travis-ci.org/Commit451/okyo.svg?branch=master)](https://travis-ci.org/Commit451/okyo) [![](https://jitpack.io/v/Commit451/okyo.svg)](https://jitpack.io/#Commit451/okyo)

# Usefulness
```java
//read
byte[] bytes = Okyo.readFileAsByteArray(file);
String content = Okyo.readFileAsString(file);
//write
Okyo.writeInputStreamToFile(inputStream, file);
Okyo.writeByteArrayToFile(bytes, file);
Okyo.writeByteArrayToFile(bytes, file);
Okyo.writeStringToFile(string, file);
Okyo.writeFileToFile(readFile, writeFile);
```

License
--------

    Copyright 2017 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
