package co.id.melon.examplenestedrv

object Config {
    private const val BASE_URL = BuildConfig.BASE_URL
    const val URL_AUTH = "${BASE_URL}auth-login"
    const val URL_CHECKED_CONVERSION = "${BASE_URL}api/penukaran"
    const val URL_REPORT_CONVERSION = "${BASE_URL}api/report-penukaran"
    const val URL_CONVERSION_PROCESS = "${BASE_URL}api/penukaran-proses"
    const val URL_CHECK_DATA_SALES = "${BASE_URL}api/penjualan"
    const val URL_PROCESS_SALES = "${BASE_URL}api/penjualan-proses"
    const val URL_REPORT_SALES = "${BASE_URL}api/report-penjualan"
    const val URL_GATE_CHECKIN_CHECK = "${BASE_URL}api/gate-in"
    const val URL_GATE_CHECKIN_PROCESS = "${BASE_URL}api/gate-in-proses"
    const val URL_GATE_REPORT = "${BASE_URL}api/report-gate"
}