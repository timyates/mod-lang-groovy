/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vertx.groovy.platform.impl

import org.vertx.java.core.Vertx as JVertx
import org.vertx.java.core.VoidResult
import org.vertx.java.platform.Container as JContainer
import org.vertx.java.platform.Verticle as JVerticle

import org.vertx.groovy.core.Vertx
import org.vertx.groovy.platform.Container
import org.vertx.groovy.platform.Verticle


/**
 * @author swilliams
 *
 */
class GroovyVerticle extends JVerticle {

  private Verticle delegate

  public GroovyVerticle(Verticle delegate) {
    this.delegate = delegate
  }

  @Override
  public void setContainer(JContainer jcontainer) {
    delegate.container = new Container(jcontainer)
    super.setContainer(jcontainer)
  }

  @Override
  public void setVertx(JVertx jvertx) {
    delegate.vertx = new Vertx(jvertx)
    super.setVertx(jvertx);
  }

  @Override
  public void start() throws Exception {
    delegate.start()
  }

  @Override
  public void start(VoidResult startedResult) throws Exception {
    delegate.start(startedResult)
  }

  @Override
  public void stop() throws Exception {
    delegate.stop()
  }

}
