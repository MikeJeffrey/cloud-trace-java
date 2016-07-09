// Copyright 2016 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.cloud.trace.guice.servlet;

import com.google.cloud.trace.ManagedTracer;
import com.google.cloud.trace.TraceContextHandler;
import com.google.cloud.trace.TraceContextHandlerTracer;
import com.google.cloud.trace.Tracer;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.RequestScoped;

public class RequestTraceContextHandlerTracerModule extends AbstractModule {
  @Override
  protected void configure() {}

  @Provides
  @RequestScoped
  ManagedTracer provideManagedTracer(Tracer tracer, TraceContextHandler traceContextHandler) {
    return new TraceContextHandlerTracer(tracer, traceContextHandler);
  }
}