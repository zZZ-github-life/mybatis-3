/*
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

/**
 * @author Clinton Begin
 */
public enum ExecutorType {

  //每次执行都创建一个新的预处理语句（PreparedStatement）对象。
  //不进行复用，适用于执行简单的、不重复的 SQL 语句。
  SIMPLE,

  //在执行时会重用预处理语句对象。
  //对于相同的 SQL 语句，会重用预处理语句，提高执行效率。
  //适用于执行相同或类似的 SQL 语句，但不同参数的情况。
  REUSE,

  //将一批 SQL 语句一次性发送到数据库执行，可以提高性能。
  //适用于执行批量插入、更新或删除等操作。
  BATCH

}
