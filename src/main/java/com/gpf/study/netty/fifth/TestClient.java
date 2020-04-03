package com.gpf.study.netty.fifth;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            // bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new TestClientInitializer());
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyTestClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8898).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
