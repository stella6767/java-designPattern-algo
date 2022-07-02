package kt2.ch11

/**
 * 유틸성 함수를 만들 떄 파일 최상단에
 */


fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}
