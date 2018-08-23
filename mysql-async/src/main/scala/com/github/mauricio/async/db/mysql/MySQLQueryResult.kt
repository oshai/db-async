
package com.github.mauricio.async.db.mysql

import com.github.mauricio.async.db.ResultSet
import com.github.mauricio.async.db.QueryResult

class MySQLQueryResult(
  rowsAffected: Long,
  message: String,
  val lastInsertId: Long,
  val statusFlags: Int,
  val warnings: Int,
  rows: Option<ResultSet> = None) : QueryResult(rowsAffected, message, rows)