package ru.clevertec.plugins.filediff

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class FileDiffTask extends DefaultTask {
    @InputFile
    abstract RegularFileProperty getFile1()
    @InputFile
    abstract RegularFileProperty getFile2()
    @OutputFile
    abstract RegularFileProperty getResultFile()

    FileDiffTask() {
        resultFile.convention(project.layout.buildDirectory.file('diff-result.txt'))
    }

    @TaskAction
    def diff() {
        String diffResult
        if (size(file1) == size(file2)) {
            diffResult = "Файлы имеют одинаковый размер - ${file1.get().asFile.size()} байтов."
        } else {
            File largestFile = size(file1) > size(file2) ? file1.get().asFile: file2.get().asFile
            diffResult = "${largestFile.toString()} имеет больший размер в ${largestFile.size()} байтов."
        }

        resultFile.get().asFile.write diffResult

        println "Файл записан в $resultFile"
        println diffResult
    }

    private static long size(RegularFileProperty regularFileProperty) {
        return regularFileProperty.get().asFile.size()
    }
}
