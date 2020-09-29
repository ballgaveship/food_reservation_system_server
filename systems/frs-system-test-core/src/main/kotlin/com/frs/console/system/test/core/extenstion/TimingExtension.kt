package com.frs.console.system.test.core.extenstion

import mu.KLogger
import mu.KotlinLogging
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext

/*
This class is referenced from
https://junit.org/junit5/docs/current/user-guide/#extensions-lifecycle-callbacks-before-after-execution
https://github.com/junit-team/junit5/blob/master/documentation/src/test/java/example/timing/TimingExtension.java
*/

class TimingExtension : BeforeTestExecutionCallback, AfterTestExecutionCallback {

    companion object {
        private val logger: KLogger = KotlinLogging.logger { }
        private const val START_TIME = "start time"
    }

    override fun beforeTestExecution(context: ExtensionContext) {
        getStore(context).put(START_TIME, System.currentTimeMillis())
        val testMethod = context.requiredTestMethod
        logger.info { String.format("[beforeTestExecution] Method [%s] start.", testMethod.name) }
    }

    override fun afterTestExecution(context: ExtensionContext) {
        val testMethod = context.requiredTestMethod
        val startTime = getStore(context).remove(START_TIME, Long::class.javaPrimitiveType)
        val duration = System.currentTimeMillis() - startTime
        logger.info { String.format("[afterTestExecution] Method [%s] took %s ms.", testMethod.name, duration) }
    }

    private fun getStore(context: ExtensionContext): ExtensionContext.Store {
        return context.getStore(ExtensionContext.Namespace.create(javaClass, context.requiredTestMethod))
    }
}