
package com.github.mauricio.async.db.util

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext

object ExecutorServiceUtils {
  val CachedThreadPool = Executors.newCachedThreadPool(DaemonThreadsFactory("db-async-funault"))
  //val CachedExecutionContext = ExecutionContext.fromExecutor( CachedThreadPool )

  fun newFixedPool( count : Int, name: String ) : ExecutorService {
    return Executors.newFixedThreadPool( count, DaemonThreadsFactory(name) )
  }

}
