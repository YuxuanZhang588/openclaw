package ai.openclaw.android.gateway

import android.util.Log

data class GatewayEndpoint(
  val stableId: String,
  val name: String,
  val host: String,
  val port: Int,
  val lanHost: String? = null,
  val tailnetDns: String? = null,
  val gatewayPort: Int? = null,
  val canvasPort: Int? = null,
  val tlsEnabled: Boolean = false,
  val tlsFingerprintSha256: String? = null,
) {
  companion object {
    fun manual(host: String, port: Int): GatewayEndpoint {
      Log.d("OpenClawDebug", "GatewayEndpoint.manual() called with host=$host, port=$port")
      val endpoint = GatewayEndpoint(
        stableId = "manual|${host.lowercase()}|$port",
        name = "$host:$port",
        host = host,
        port = port,
        tlsEnabled = false,
        tlsFingerprintSha256 = null,
      )
      Log.d("OpenClawDebug", "Created manual endpoint: stableId=${endpoint.stableId}, host=${endpoint.host}, port=${endpoint.port}")
      return endpoint
    }
  }
}
