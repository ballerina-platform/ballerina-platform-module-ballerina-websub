/*
 * Copyright (c) 2021 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.websub.task.service.path;

import io.ballerina.projects.ProjectKind;
import io.ballerina.stdlib.websub.Constants;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * {@code BalProjectServicePathGenerator} generates unique-service-path for subscriber-service defined
 * in ballerina projects.
 */
public class BalProjectServicePathGenerator extends AbstractServicePathGenerator {
    @Override
    public boolean isSupported(ProjectKind projectType) {
        return ProjectKind.BUILD_PROJECT.equals(projectType);
    }

    // for ballerina-project, intermediate `resources` directory will be created inside `<project-root>/target/bin`
    @Override
    protected Path retrieveResourcePath(Path projectRoot) {
        return projectRoot
                .resolve(Constants.TARGET_DIR_NAME)
                .resolve(Paths.get(Constants.BIN_DIR_NAME, Constants.RESOURCES_DIR_NAME))
                .resolve(Constants.PACKAGE_ORG).resolve(Constants.PACKAGE_NAME);
    }
}
