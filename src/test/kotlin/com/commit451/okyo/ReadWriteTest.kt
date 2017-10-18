package com.commit451.okyo

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.nio.file.Paths

class ReadWriteTest {

    @Test
    fun testReadFile() {
        val currentRelativePath = Paths.get("")
        val parentFile = currentRelativePath.toAbsolutePath().toFile()
        val licenseFile = File(parentFile, "LICENSE.txt")
        val contents = Okyo.readFileAsString(licenseFile)
        Assert.assertTrue(contents.contains("Apache"))
    }
}