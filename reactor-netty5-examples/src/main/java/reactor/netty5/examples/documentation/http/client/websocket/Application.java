/*
 * Copyright (c) 2020-2022 VMware, Inc. or its affiliates, All Rights Reserved.
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
package reactor.netty5.examples.documentation.http.client.websocket;

import io.netty5.util.CharsetUtil;
import reactor.core.publisher.Flux;
import reactor.netty5.http.client.HttpClient;

public class Application {

	public static void main(String[] args) {
		HttpClient client = HttpClient.create();

		client.websocket()
		      .uri("wss://echo.websocket.org")
		      .handle((inbound, outbound) -> {
		          inbound.receive()
		                 .asString()
		                 .take(1)
		                 .subscribe(System.out::println);

		          final byte[] msgBytes = "hello".getBytes(CharsetUtil.ISO_8859_1);
		          return outbound.send(Flux.just(outbound.alloc().copyOf(msgBytes), outbound.alloc().copyOf(msgBytes)))
		                         .neverComplete();
		      })
		      .blockLast();
	}
}