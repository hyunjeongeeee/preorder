# http_request_tool.py

# requests 라이브러리를 import합니다. 이 라이브러리는 HTTP 요청을 보내기 위해 사용됩니다.
import requests

# threading 모듈을 import합니다. 이 모듈은 병렬 처리를 위해 사용됩니다.
import threading

# concurrent.futures 모듈에서 ThreadPoolExecutor를 import합니다.
from concurrent.futures import ThreadPoolExecutor

# send_http_request 함수를 정의합니다. 이 함수는 지정된 URL로 HTTP 요청을 보냅니다.
def send_http_request(url):
    try:
        # 지정된 URL에 GET 요청을 보내고 응답을 받습니다.
        response = requests.get(url)
        # 요청이 완료되면 URL과 상태 코드를 출력합니다.
        print(f"Request to {url} completed with status code {response.status_code}")
    except Exception as e:
        # 요청이 실패하면 오류 메시지를 출력합니다.
        print(f"Error sending request to {url}: {e}")

# main 함수를 정의합니다. 이 함수는 프로그램의 주 진입점입니다.
def main():
    # 동시에 보낼 요청의 수를 설정합니다.
    num_requests = 10

    # 대상 URL을 설정합니다.
    target_url = "https://localhost:8000"

    # ThreadPoolExecutor를 사용하여 동시 요청을 보내는 스레드 풀을 생성합니다.
    with ThreadPoolExecutor(max_workers=num_requests) as executor:
        # 리스트 컴프리헨션을 사용하여 작업 목록을 생성합니다.
        tasks = [executor.submit(send_http_request, target_url) for _ in range(num_requests)]

        # 모든 작업이 완료될 때까지 대기합니다.
        for future in tasks:
            future.result()

# 현재 스크립트가 직접 실행될 때만 main 함수를 호출합니다.
if __name__ == "__main__":
    main()
