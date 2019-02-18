package br.com.cateno.sdk.core;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = IrisModule.class)
interface ClientFactory {

  Iris buildClient();
}
