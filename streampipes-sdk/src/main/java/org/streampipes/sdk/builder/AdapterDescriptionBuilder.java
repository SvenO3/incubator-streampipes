/*
Copyright 2018 FZI Forschungszentrum Informatik

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.streampipes.sdk.builder;

public class AdapterDescriptionBuilder {

  public AdapterDescriptionBuilder(String id, String label, String description) {
  }

  /**
   * Creates a new data set using the builder pattern.
   * @param id A unique identifier of the new element, e.g., com.mycompany.set.mynewdataset
   * @param label A human-readable name of the element. Will later be shown as the element name in the StreamPipes UI.
   * @param description A human-readable description of the element.
   * @return a new instance of {@link DataSetBuilder}
   */
  public static AdapterDescriptionBuilder create(String id, String label, String description) {
    return new AdapterDescriptionBuilder(id, label, description);
  }
}
