job('First_Maven_Project_Via_DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git("https://github.com/anshulc55/Jenkins_Upgradev3.git", 'main')
    }
    triggers {
        scm('H * * * *')
    }
    steps {
        maven('clean package', 'maven-samples/single-module/pom.xml')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}