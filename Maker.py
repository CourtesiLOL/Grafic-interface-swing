import os, sys, shutil
import os.path as path

from textwrap import dedent

projectPath = os.getcwd()
binPath = path.join(projectPath,"bin")
srcPath = path.join(projectPath,"src")
distPath = path.join(projectPath,"dist")

def build():

    print("Path binaries: "+binPath)
    print("Path Resources: "+srcPath)
    print("Path Distribution: "+distPath)

    print("--------------------------")

    print("Deleting dir bin")
    shutil.rmtree(binPath, ignore_errors=True)

    print("Creating dir bin")
    os.mkdir(binPath)

    print("--------------------------")
    print("Go to src path")
    os.chdir(srcPath)
    print("Path: "+os.getcwd())

    print("Start commpiling")
    os.system("javac -d "+path.join("..","bin")+" Main.java")
    os.system("javac -d "+path.join("..","bin")+path.join("com","app","*.java"))
    os.system("javac -d "+path.join("..","bin")+path.join("com","app","**","*.java"))
    print("Commpiling succesfull")

    print("returning to project path")
    os.chdir(projectPath)

def createJavaClass(className: str,isMain: bool, dirObjective: str):

    if(isMain):
        codeStr = f"""\
        public class {className} {{
        
            public static void main(String[] args) {{
        
                System.out.println("Hello world");
        
            }}
        
        }}
        """
    else:
        codeStr = f"""\
        public class {className} {{
        
            public {className}() {{
        
            }}
        
        }}
        """

    codeStr = dedent(codeStr)

    with open(path.join(dirObjective,className+".java"), 'w') as file:
            file.write(codeStr)

def createJar():
    print("Not implemented")

def createFoldes():

    filesInFolder = os.listdir()
    
    if not("bin" in filesInFolder):
        print("No estiste la carpeta bin\n")
        os.mkdir("bin")
    else:
        print("Exista ya la carpeta bin")

    if not("src" in filesInFolder):
        print("No estiste la carpeta src\n")
        os.mkdir("src")
    else:
        print("Exista ya la carpeta bin")
    
    if not("dist" in filesInFolder):
        print("No estiste la carpeta dist\n")
        os.mkdir("dist")
    else:
        print("Exista ya la carpeta bin")

def createInitialsFiles():
    os.chdir(srcPath)

    filesInFolder = os.listdir()

    if not("MANIFEST.MF" in filesInFolder):
        with open('MANIFEST.MF', 'w') as file:
            file.write("Manifest-Version: 1.0\n")
            file.write("Main-Class: Main\n")

    if not("Main.java" in filesInFolder):
        createJavaClass("Main",True,srcPath)

    if not("com" in filesInFolder):
        os.mkdir("com")
        os.mkdir("com/app")

    os.chdir(projectPath)

def createInit():
    
    createFoldes()
    createInitialsFiles()

def runBuild():
    print("Entra")
    build()
    os.chdir(binPath)
    os.system("java Main")
    os.chdir(projectPath)

def main():
    try:
        param = sys.argv[1]
        
        match param:

            case "init":
                createInit()

            case "build":
                build()
            
            case "run":
                runBuild()

            case "mkjar":
                createJar()
            


    except IndexError:
        print("missing parameter or incorrect parameter \n\n")
        print("Option list")
        print("----------------------------\n")
        print("init")
        print("create an initial java project along with its main class and manifest file\n")
        print("build")
        print("compile all java files into class files in bin folder\n")
        print("run")
        print("Build the project and execute it\n")
        print("mkjar( not implemented)")
        print("mkjar create a jar file in which all the class files in the folder bin are packaged plus a manifest file in which several things can be specified, for example the version and what the main class is\n")

main()
