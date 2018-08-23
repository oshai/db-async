
package com.github.mauricio.async.db.mysql.util

import com.github.mauricio.async.db.mysql.exceptions.CharsetMappingNotAvailableException
import java.nio.charset.Charset
import io.netty.util.CharsetUtil

object CharsetMapper {

  val Binary = 63

  val DefaultCharsetsByCharset = Map<Charset,Int>(
    CharsetUtil.UTF_8 -> 83,
    CharsetUtil.US_ASCII -> 11,
    CharsetUtil.US_ASCII -> 65,
    CharsetUtil.ISO_8859_1 -> 3,
    CharsetUtil.ISO_8859_1 -> 69
  )

  val DefaultCharsetsById = DefaultCharsetsByCharset.map { pair -> (pair._2, pair._1.name()) }

  val Instance = CharsetMapper()
}

class CharsetMapper( charsetsToIntComplement : Map<Charset,Int> = Map.empty<Charset,Int> ) {

  private var charsetsToInt = CharsetMapper.DefaultCharsetsByCharset ++ charsetsToIntComplement

  fun toInt( charset : Charset ) : Int {
    charsetsToInt.getOrElse(charset, {
      throw CharsetMappingNotAvailableException(charset)
    })
  }

}