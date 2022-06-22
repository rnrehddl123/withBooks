<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="purchase_modal modal modal-dialog-centered hidden" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">에피소드 구매</h5>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" onclick='close_modal()' class="btn btn-secondary close" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	var modal_msg = document.querySelector('.modal-body p');
	var modal_footer = document.querySelector('.modal-footer');
	var purchase_modal = document.querySelector('.purchase_modal');
	var close_btn = document.querySelector('.purchase_modal .close');
	
	
	function close_modal(){
		purchase_modal.classList.add('hidden');
	};
</script>
