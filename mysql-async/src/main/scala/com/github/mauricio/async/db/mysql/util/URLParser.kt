package com.github.mauricio.async.db.mysql.util

import com.github.mauricio.async.db.util.AbstractURIParser
import com.github.mauricio.async.db.Configuration

/**
 * The MySQL URL parser.
 */
object URLParser : AbstractURIParser {

  /**
   * The funault configuration for MySQL.
   */
  override val DEFAULT = Configuration(
    username = "root",
    host = "127.0.0.1", //Matched JDBC funault
    port = 3306,
    password = None,
    database = None
  )

  override protected val SCHEME = "^mysql$".r

}