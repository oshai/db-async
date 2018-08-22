package com.github.mauricio.async.db.util

import java.util.concurrent.ExecutorService
import scala.concurrent.ExecutionContextExecutorService
import scala.concurrent.ExecutionContext

class Worker(val executionContext: ExecutorService) {

  companion object {
    val log = Log.get()

    fun invoke(): Worker = Worker(ExecutorServiceUtils.newFixedPool(1, "db-async-worker"))

  }

  fun action(f: () -> Unit) {
    this.executionContext.execute {
      try {
        f()
      } catch (e: Exception) {
        log.error("Failed to execute task %s".format(f), e)
      }
    }
  }

  fun shutdown() {
    this.executionContext.shutdown()
  }

}
