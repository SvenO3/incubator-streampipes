/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.streampipes.pe.examples.jvm;

import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;
import org.streampipes.dataformat.json.JsonDataFormatFactory;
import org.streampipes.messaging.jms.SpJmsProtocolFactory;
import org.streampipes.messaging.kafka.SpKafkaProtocolFactory;
import org.streampipes.pe.examples.jvm.config.ExamplesJvmConfig;
import org.streampipes.pe.examples.jvm.engine.ExampleExternalEngineController;
import org.streampipes.pe.examples.jvm.outputstrategy.AppendOutputController;
import org.streampipes.pe.examples.jvm.outputstrategy.CustomOutputController;
import org.streampipes.pe.examples.jvm.outputstrategy.CustomTransformOutputController;
import org.streampipes.pe.examples.jvm.outputstrategy.FixedOutputController;
import org.streampipes.pe.examples.jvm.outputstrategy.KeepOutputController;
import org.streampipes.pe.examples.jvm.outputstrategy.TransformOutputController;
import org.streampipes.pe.examples.jvm.staticproperty.CollectionExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.MultiValueSelectionExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.NaryMappingPropertyExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.NumberParameterExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.NumberParameterWithRangeExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.RuntimeResolvableSingleValue;
import org.streampipes.pe.examples.jvm.staticproperty.SecretStaticPropertyExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.SingleValueSelectionExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.StaticPropertyAlternativesController;
import org.streampipes.pe.examples.jvm.staticproperty.TextParameterExampleController;
import org.streampipes.pe.examples.jvm.staticproperty.UnaryMappingPropertyExampleController;

public class ExamplesInit extends StandaloneModelSubmitter {

  public static void main(String[] args) {
    DeclarersSingleton
            .getInstance()
            .add(new TextParameterExampleController())
            .add(new NumberParameterExampleController())
            .add(new NumberParameterWithRangeExampleController())
            .add(new UnaryMappingPropertyExampleController())
            .add(new NaryMappingPropertyExampleController())
            .add(new SingleValueSelectionExampleController())
            .add(new MultiValueSelectionExampleController())
            .add(new CollectionExampleController())
            .add(new RuntimeResolvableSingleValue())
            .add(new StaticPropertyAlternativesController())
            .add(new SecretStaticPropertyExampleController())

            .add(new AppendOutputController())
            .add(new CustomOutputController())
            .add(new FixedOutputController())
            .add(new CustomTransformOutputController())
            .add(new TransformOutputController())
            .add(new KeepOutputController())

            .add(new ExampleExternalEngineController());

    DeclarersSingleton.getInstance().registerDataFormat(new JsonDataFormatFactory());
    DeclarersSingleton.getInstance().registerProtocol(new SpKafkaProtocolFactory());
    DeclarersSingleton.getInstance().registerProtocol(new SpJmsProtocolFactory());

    new ExamplesInit().init(ExamplesJvmConfig.INSTANCE);
  }
}
