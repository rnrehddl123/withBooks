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

  	<div class="chart_wrapper flex">
	  	<div class="plot" id="plot1"></div>
	    <div class="plot" id="plot2"></div>
	    <div class="plot" id="plot3"></div>
	    <div class="plot" id="plot4"></div>
	    <div class="plot" id="plot5"></div>
	    <div class="plot" id="plot6"></div>
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
  url="http://192.168.219.135:8080/withbooks/adminNoChart",
  method="POST",
  headers={"Content-Type": "application/json"},
  body=json.dumps({"email": "aa", "password": "bb"})
)

member_info = json.dumps(await member.json())


history = await pyfetch(
  url="http://192.168.219.135:8080/withbooks/purchaseHistoryChartList",
  method="GET",
)
history_info = json.dumps(await history.json())


history = await pyfetch(
  url="http://192.168.219.135:8080/withbooks/purchaseHistoryWChartList",
  method="GET",
)
heat_info = json.dumps(await history.json())


df_member_info=pd.read_json(member_info)
df_member_info.loc[df_member_info['Member_authority'] != df_member_info['Member_authority'], 'Member_authority'] = 'client'



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

df_member_info['Member_birth'] = pd.to_datetime(df_member_info['Member_birth'])
df_member_info['Year'] = df_member_info['Member_birth'].dt.year
fig5, ax5 = plt.subplots()
ax5.set(ylim=(1970, 2020))
sns.boxplot(x="Member_sex", y="Year", data=df_member_info,ax=ax5)
pyscript.write('plot5', fig5)

man = (df_history_info.MEMBER_SEX == 'man')
woman = (df_history_info.MEMBER_SEX == 'woman')
male=df_history_info[man].groupby(by=['PURCHASE_DATE'],as_index=False)['PURCHASE_PRICE'].sum()
female=df_history_info[woman].groupby(by=['PURCHASE_DATE'],as_index=False)['PURCHASE_PRICE'].sum()
fig6, ax6 = plt.subplots()

sns.lineplot(x="PURCHASE_DATE",y="PURCHASE_PRICE",
             data=female,label='female',ax=ax6)
sns.lineplot(x="PURCHASE_DATE",y="PURCHASE_PRICE",
             data=male,label='male',ax=ax6)
pyscript.write('plot6', fig6)
    </py-script>
  
<script>
	document.body.style.overflow = "hidden";
</script>
<%@ include file="../adminFooter.jsp"%>
