package com.github.jupittar.vmovier.network;

import com.github.jupittar.vmovier.network.entities.RawResponse;

import rx.functions.Func1;

public class ExtractDataFunc<T> implements Func1<RawResponse<T>, T> {

  @Override
  public T call(RawResponse<T> tRawResponse) {
    if (tRawResponse.getStatus() != null && !"0".equals(tRawResponse.getStatus())) {
      throw new RuntimeException(tRawResponse.getMsg());
    }
    return tRawResponse.getData();
  }
}
