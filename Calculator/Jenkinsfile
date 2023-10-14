pipeline{
 agent any
 environment {
PATH ="/usr/share/maven:$PATH"
}

    parameters {
        choice(
            choices: ['Dev', 'Prod'],
            description: 'Select the environment',
            name: 'Environment'
        )
    }


stages{

     

    stage('Code checkout according to environment') {
    steps {
        script{
            if(params.Environment=='Dev'){
    checkout scmGit(branches: [[name: '*/Dev']], extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Calculator']]]], userRemoteConfigs: [[credentialsId: 'newGitlabCred', url: 'https://git.nagarro.com/freshertraining2023/harshitaagrawal.git']])
            }
            
            else if(params.Environment=='Prod'){
                checkout scmGit(branches: [[name: '*/Prod']], extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Calculator']]]], userRemoteConfigs: [[credentialsId: 'newGitlabCred', url: 'https://git.nagarro.com/freshertraining2023/harshitaagrawal.git']])
            }

            else{
                error('Invalid choice')
            }
        } 
        }
    }


    stage("Maven Build"){
        steps{
            sh" mvn -f Calculator/pom.xml clean install"
        }
    }

        stage("Unit Testing"){
        steps{
            sh "mvn -f Calculator/pom.xml test"
        }
    }

    stage("Artifactory_Upload"){
            steps{
                rtUpload (
                serverId: 'Artifactory',
                spec: '''{
                "files": [
                    {
                    "pattern": "*.war",
                    "target": "key/"
                    }
                ]
                }''',
                )
            }
    } 
    
    
    stage('SonarQube analysis') {
        steps{
            withSonarQubeEnv('server-sonar') {
                sh "mvn -f Calculator/pom.xml clean install sonar:sonar"
            }
        }   
    }    



    stage('Create image for Docker') {
        steps {
            sh 'docker build -t mydockerrepo ./Calculator/'
        }
    }
    
   stage('Run the container'){
        steps{
            script{
            def docker_container = sh(returnStdout: true, script: 'docker ps -a -f name="MavenAssessment2" -q')
            if(docker_container)
                {
                    sh "docker stop ${docker_container}"
                    sh "docker rm --force ${docker_container}"
                }
            if (params.Environment == 'Dev')
            {
                sh 'docker run -d --name MavenAssessment2 -p 8084:8080 mydockerrepo'
            }
            else
            {
                sh 'docker run -d --name MavenAssessment2 -p 8086:8080 mydockerrepo'
            }
            }
        }
   }


}

      post{
        always{
            mail to: "harshitaagrawal091@gmail.com",
            subject: "Jenkins Job with Build #${BUILD_NUMBER}",
            body: "Jenkins Job with Build #${BUILD_NUMBER}. Please go to ${BUILD_URL} and verify the build."
        }
    }
}
