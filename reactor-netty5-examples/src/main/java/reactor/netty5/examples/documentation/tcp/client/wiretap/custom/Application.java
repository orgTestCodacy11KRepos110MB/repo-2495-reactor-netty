/*
 * Copyright (c) 2021-2022 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.netty5.examples.documentation.tcp.client.wiretap.custom;

import io.netty5.handler.logging.LogLevel;
import reactor.netty5.Connection;
import reactor.netty5.tcp.TcpClient;
import reactor.netty5.transport.logging.AdvancedByteBufFormat;

public class Application {

	public static void main(String[] args) {
		Connection connection =
				TcpClient.create()
				         .wiretap("logger-name", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL) //<1>
				         .host("example.com")
				         .port(80)
				         .connectNow();

		connection.onDispose()
		          .block();
	}
}