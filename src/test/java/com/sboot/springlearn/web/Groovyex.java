package com.sboot.springlearn.web;
import java.util.*;
import groovy.lang.GroovyShell ;
import groovy.lang.GroovyClassLoader ;
import groovy.util.GroovyScriptEngine ;
import java.io.File ;

class Groovyex {
    static void runWithGroovyShell() throws Exception {
        Scanner sc = new Scanner(System.in);

        new GroovyShell().evaluate( new File( "./src/main/resources/Scripts/DemoScript.groovy" ) ) ;

    }
    // Used to invoke demo method in test.groovy
    static void runWithGroovyClassLoader() throws Exception {
        // Declaring a class to conform to a java interface class would get rid of
        // a lot of the reflection here
        Class scriptClass = new GroovyClassLoader().parseClass( new File( "./src/main/resources/Scripts/test.groovy" ) ) ;
        Object scriptInstance = scriptClass.newInstance() ;
        scriptClass.getDeclaredMethod( "demo", new Class[] {} ).invoke( scriptInstance, new Object[] {} ) ;
    }
     // Used to invoke demo method in test.groovy
    static void runWithGroovyScriptEngine() throws Exception {
        // Declaring a class to conform to a java interface class would get rid of
        // a lot of the reflection here
        Class scriptClass = new GroovyScriptEngine( "." ).loadScriptByName( "./src/main/resources/Scripts/test.groovy" ) ;
        Object scriptInstance = scriptClass.newInstance() ;
        scriptClass.getDeclaredMethod( "demo", new Class[] {} ).invoke( scriptInstance, new Object[] {} ) ;
    }

    public static void main( String[] args ) throws Exception {
        runWithGroovyShell() ;
        runWithGroovyClassLoader() ;
      runWithGroovyScriptEngine() ;
    }
}