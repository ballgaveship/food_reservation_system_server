#!/bin/bash
echo "> Start Health check"
echo "> curl -s http://localhost/frs/v1/health "

for RETRY_COUNT in {1..15}
do
  RESPONSE=$(curl -s http://localhost/frs/v1/health)
  UP_COUNT=$(echo $RESPONSE | grep 'UP' | wc -l)

  if [ $UP_COUNT -ge 1 ]
  then # $up_count >= 1 ("UP" 문자열이 있는지 검증)
      echo "> Health check Success"
      break
  else
      echo "> The response of health check is unknown or status is Down."
      echo "> Health check: ${RESPONSE}"
  fi

  if [ $RETRY_COUNT -eq 10 ]
  then
    echo "> Health check Fail. "
    exit 1
  fi

  echo "> Health check Not Connected. Try Again..."
  sleep 10
done
exit 0