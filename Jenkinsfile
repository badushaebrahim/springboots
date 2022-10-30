pipeline{
	agent any
// 	environment {
// //     EXAMPLE_KEY = credentials('example-credentials-id') // Secret value is 'sec%ret'
//   }
	stages{
		stage("init "){
			steps{
				bat"git clone https://github.com/badushaebrahim/springboots.git"
				echo message: "Git clone complete"
			}		}

		stage("jar creation"){
			steps{
				bat" cd learn && cd learn && mvn clean package"
			}
		}
		
	}

}