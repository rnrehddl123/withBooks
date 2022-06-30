<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminHeader.jsp"%>
    <head>
      <link rel="stylesheet" href="https://pyscript.net/alpha/pyscript.css" />
      <script defer src="https://pyscript.net/alpha/pyscript.js"></script>
      <py-env>
        - numpy
        - pandas
        - matplotlib
        - seaborn
      </py-env>
    </head>

  <body>
  	<div class="chart_wrapper">
	  	<div id="plot1"></div>
	    <div id="plot2"></div>
	    <div id="plot3"></div>
	    <div id="plot4"></div>
  	</div>
    <py-script>
import matplotlib.pyplot as plt
import numpy as np
import asyncio
from pyodide.http import pyfetch
import seaborn as sns
import json
import pandas as pd


member = await pyfetch(
  url="http://localhost:8080/withbooks/adminNoChart",
  method="POST",
  headers={"Content-Type": "application/json"},
  body=json.dumps({"email": "aa", "password": "bb"})
)

member_info = json.dumps(await member.json())


history = await pyfetch(
  url="http://localhost:8080/withbooks/purchaseHistoryChartList",
  method="GET",
)
history_info = json.dumps(await history.json())


history = await pyfetch(
  url="http://localhost:8080/withbooks/purchaseHistoryWChartList",
  method="GET",
)
heat_info = json.dumps(await history.json())


df_member_info=pd.read_json(member_info)
df_member_info.loc[df_member_info['Member_authority'] != df_member_info['Member_authority'], 'Member_authority'] = 'buyer'

fig1, ax1 = plt.subplots()
sns.countplot(x="Member_sex", hue="Member_authority", data=df_member_info,ax=ax1)
pyscript.write('plot1', fig1)

fig2, ax2 = plt.subplots()
sns.countplot(x="Member_authority", hue="Member_sex", data=df_member_info,ax=ax2)
pyscript.write('plot2', fig2)


df_history_info=pd.read_json(history_info)
mean=df_history_info.groupby(by=['PURCHASE_DATE'],as_index=False)['PURCHASE_PRICE'].sum()
fig3, ax3 = plt.subplots()
sns.lineplot(x="PURCHASE_DATE",y="PURCHASE_PRICE",data=mean,ax=ax3)
pyscript.write('plot3', fig3)


df_hit=pd.read_json(heat_info)
df_hit = df_hit.pivot_table(index='MONTHLYDATA',columns='MEMBER_ID',values='COUNT')
fig4, ax4 = plt.subplots()
sns.heatmap(df_hit)
pyscript.write('plot4', fig4)
    </py-script>
  </body>
<%@ include file="../adminFooter.jsp"%>
